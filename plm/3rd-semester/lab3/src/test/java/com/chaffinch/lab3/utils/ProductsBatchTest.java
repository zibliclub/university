package com.chaffinch.lab3.utils;

import com.chaffinch.lab3.utils.classes.products.foundation.Pack;
import com.chaffinch.lab3.utils.classes.products.PackedSetProducts;
import com.chaffinch.lab3.utils.classes.products.ProductsBatch;
import com.chaffinch.lab3.utils.classes.products.itemized.ItemizedProduct;
import com.chaffinch.lab3.utils.classes.products.itemized.PackedItemizedProduct;
import com.chaffinch.lab3.utils.classes.products.weight.PackedWeightProduct;
import com.chaffinch.lab3.utils.classes.products.weight.WeightProduct;
import com.chaffinch.lab3.utils.interfaces.PackedProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductsBatchTest {
    private static final Pack SMALL_PACK = new Pack("Small Pack", 10);
    private static final Pack MEDIUM_PACK = new Pack("Medium Pack", 20);
    private static final Pack BIG_PACK = new Pack("Big Pack", 30);

    private static final WeightProduct CHRISTMAS_TEA = new WeightProduct(
            "Christmas Tea",
            "Your Christmas tea party will be remembered forever"
    );
    private static final ItemizedProduct CHRISTMAS_TREE_DECORATION = new ItemizedProduct(
            "Christmas Tree Decoration",
            "Your Christmas tree has never been more mesmerizing",
            10
    );

    @Test
    @DisplayName("1. Checking the functionality of the ProductsBatch class")
    void testProductsBatch() {
        ProductsBatch christmasGifts = getProductsBatch();

        System.out.println(christmasGifts);

        assertEquals(
                290,
                christmasGifts.getWeight(),
                "The weight of the consignment must match the gross weight of all its contents"
        );
    }

    private static ProductsBatch getProductsBatch() {
        PackedItemizedProduct christmasTreeDecorationsSet = new PackedItemizedProduct(
                CHRISTMAS_TREE_DECORATION,
                5,
                SMALL_PACK
        );
        PackedWeightProduct christmasTeaSet = new PackedWeightProduct(
                CHRISTMAS_TEA,
                50,
                MEDIUM_PACK
        );
        PackedSetProducts bigGiftBox = new PackedSetProducts(
                "Christmas Gift Box",
                new PackedProduct[]{christmasTreeDecorationsSet, christmasTeaSet},
                BIG_PACK
        );

        return new ProductsBatch(
                "A batch of products with Christmas gifts",
                new PackedProduct[]{christmasTreeDecorationsSet, christmasTeaSet, bigGiftBox}
        );
    }
}