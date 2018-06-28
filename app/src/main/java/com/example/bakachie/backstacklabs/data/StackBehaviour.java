package com.example.bakachie.backstacklabs.data;

import com.example.bakachie.backstacklabs.fragment.ForthFragment;
import com.example.bakachie.backstacklabs.fragment.SecondFragment;

import java.util.Arrays;
import java.util.List;

public final class StackBehaviour {
    private static List<String> stack = Arrays.asList(SecondFragment.class.getName(), ForthFragment.class.getName());

    public static boolean needToBeMissed(final String fragmentName) {
        return stack.contains(fragmentName);
    }
}
