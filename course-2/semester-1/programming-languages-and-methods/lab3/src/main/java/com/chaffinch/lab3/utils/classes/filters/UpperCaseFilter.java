package com.chaffinch.lab3.utils.classes.filters;

import com.chaffinch.lab3.utils.interfaces.Filter;

public class UpperCaseFilter implements Filter {
    public boolean apply(String str) {
        return str.equals(str.toUpperCase());
    }
}
