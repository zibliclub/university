package com.chaffinch.lab3.utils.classes;

import com.chaffinch.lab3.utils.classes.products.PackedSetProducts;
import com.chaffinch.lab3.utils.classes.products.ProductsBatch;
import com.chaffinch.lab3.utils.classes.products.weight.PackedWeightProduct;
import com.chaffinch.lab3.utils.interfaces.Filter;
import com.chaffinch.lab3.utils.interfaces.PackedProduct;

public class ProductService {
    public int countByFilter(ProductsBatch batch, Filter filter) {
        int count = 0;
        for (PackedProduct product : batch.getProducts()) {
            if (filter.apply(product.getName())) {
                count++;
            }
        }

        return count;
    }

    public int countByFilterDeep(ProductsBatch batch, Filter filter) {
        int count = 0;
        for (PackedProduct product : batch.getProducts()) {
            if (checkFilter(product, filter)) count++;
        }

        return count;
    }

    public boolean checkAllWeighted(ProductsBatch batch) {
        for (PackedProduct product : batch.getProducts()) {
            if (
                    !(product instanceof PackedSetProducts set &&
                            setOfWeighted(set) ||
                            product instanceof PackedWeightProduct)
            ) return false;
        }

        return true;
    }

    private boolean checkFilter(PackedProduct product, Filter filter) {
        if (filter.apply(product.getName())) return true;

        if (product instanceof PackedSetProducts set) {
            for (PackedProduct byProduct : set.getProducts()) {
                return checkFilter(byProduct, filter);
            }
        }

        return false;
    }

    private boolean setOfWeighted(PackedSetProducts set) {
        for (PackedProduct product : set.getProducts()) {
            if (
                    !(product instanceof PackedSetProducts bySet &&
                            setOfWeighted(bySet) ||
                            product instanceof PackedWeightProduct)
            ) return false;
        }

        return true;
    }
}
