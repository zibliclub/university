package com.chaffinch.lab3.utils.classes.filters;

import com.chaffinch.lab3.utils.interfaces.Filter;

public class ContainsFilter implements Filter {
    private final String sequence;

    public ContainsFilter(String sequence) {
        this.sequence = sequence;
    }

    public boolean apply(String str) {
        return str.contains(sequence);
    }

    public String getSequence() {
        return sequence;
    }
}
