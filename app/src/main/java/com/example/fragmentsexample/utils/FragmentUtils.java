package com.example.fragmentsexample.utils;


import android.support.annotation.AnimRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.example.fragmentsexample.ui.fragment.BaseFragment;

public class FragmentUtils {

    /*
     * Métodos Genericos para utilização de Fragments
     */

    public static FragmentTransaction ensureTransaction(final FragmentManager fragmentManager) {
        return fragmentManager.beginTransaction();
    }

    public static Fragment getFragment(final FragmentManager fragmentManager, final String tag) {
        return fragmentManager.findFragmentByTag(tag);
    }

    public static Fragment getFragment(final FragmentManager fragmentManager, final int id) {
        return fragmentManager.findFragmentById(id);
    }

    public static void attachFragment(final FragmentTransaction fragmentTransaction, final int content, final BaseFragment fragment, final String tag) {
        if (fragment != null) {
            if (fragment.isDetached()) {
                fragmentTransaction.attach(fragment);
            } else if (!fragment.isAdded()) {
                fragmentTransaction.add(content, fragment, tag);
            }
        }
    }

    public static void reAttachFragment(final FragmentTransaction fragmentTransaction, final BaseFragment fragment) {
        fragmentTransaction.attach(fragment);
    }

    public static void detachFragment(final FragmentTransaction fragmentTransaction, final BaseFragment fragment) {
        if (fragment != null && !fragment.isDetached()) {
            fragmentTransaction.detach(fragment);
        }
    }

    public static void removeFragment(final FragmentManager fragmentManager, final BaseFragment fragment, final boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = ensureTransaction(fragmentManager);
        fragmentTransaction.remove(fragment);
        commitTransactions(fragmentTransaction, addToBackStack);
    }

    public static void replaceFragment(final FragmentTransaction fragmentTransaction, final BaseFragment fragment, final int containerToReplace, final boolean addToBackStack) {
        fragmentTransaction.replace(containerToReplace, fragment);
        commitTransactions(fragmentTransaction, addToBackStack);
    }


    public static void replaceFragment(final FragmentManager fragmentManager, final BaseFragment fragment, final String tag, final int containerToReplace, final boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = ensureTransaction(fragmentManager);
        fragmentTransaction.replace(containerToReplace, fragment, tag);
        commitTransactions(fragmentTransaction, addToBackStack);
    }

    public static void replaceFragmentWithAnimation(final FragmentTransaction fragmentTransaction, final BaseFragment fragment, final String tag, final int containerToReplace, final boolean addToBackStack, @AnimRes final int animationEnter, @AnimRes final int animationExit) {
        if (addToBackStack)
            fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.setCustomAnimations(animationEnter, animationExit);
        fragmentTransaction.replace(containerToReplace, fragment).commit();
    }

    public static void replaceFragmentWithAnimation(final FragmentTransaction fragmentTransaction, final BaseFragment fragment, final String tag, final int containerToReplace, final boolean addToBackStack, @AnimRes final int animationEnter, @AnimRes final int animationExit, @AnimRes final int animationPopEnter, @AnimRes final int animationPopExit) {
        if (addToBackStack)
            fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.setCustomAnimations(animationEnter, animationExit, animationPopEnter, animationPopExit);
        fragmentTransaction.replace(containerToReplace, fragment).commit();
    }

    public static void commitTransactions(final FragmentTransaction fragmentTransaction) {
        commitTransactions(fragmentTransaction, false);
    }

    public static void commitTransactions(final FragmentTransaction fragmentTransaction, final boolean addToBackStack) {
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            if (addToBackStack)
                fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commitAllowingStateLoss();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Fragment> T findFragment(final FragmentManager fragmentManager, final String tag) {
        return (T) fragmentManager.findFragmentByTag(tag);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Fragment> T findFragment(final FragmentManager fragmentManager, final int id) {
        return (T) fragmentManager.findFragmentById(id);
    }

    public static void resetBackStack(final FragmentManager fragmentManager) {
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

}
