package com.chaffinch.lab3.utils.classes.filters;

import com.chaffinch.lab3.utils.interfaces.Filter;

public class BeginStringFilter implements Filter {
    private final String pattern;

    public BeginStringFilter(String PATTERN) {
        this.pattern = PATTERN;
    }

    public boolean apply(String str) {
        return str.startsWith(pattern);
    }

    public String getPattern() {
        return pattern;
    }
}
