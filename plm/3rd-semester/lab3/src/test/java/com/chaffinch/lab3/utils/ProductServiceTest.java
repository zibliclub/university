package com.chaffinch.lab3.utils;

import com.chaffinch.lab3.utils.classes.ProductService;
import com.chaffinch.lab3.utils.classes.filters.BeginStringFilter;
import com.chaffinch.lab3.utils.classes.filters.ContainsFilter;
import com.chaffinch.lab3.utils.classes.filters.UpperCaseFilter;
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

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    private static final Pack smallPack = new Pack("Small Pack", 10);
    private static final Pack mediumPack = new Pack("Medium Pack", 20);
    private static final Pack bigPack = new Pack("Big Pack", 30);

    private static final WeightProduct SALE_TEE = new WeightProduct(
            "SALE CHRISTMAS TEE",
            "Your Christmas tea party will be remembered forever"
    );
    private static final ItemizedProduct SALE_TREE = new ItemizedProduct(
            "SALE CHRISTMAS TREE DECORATION",
            "Your Christmas tree has never been more mesmerizing",
            10
    );

    @Test
    @DisplayName("3.1. Checking the countByFilter method")
    void testCountByFilter() {
        ProductsBatch christmasGifts = getProductsBatch1();

        System.out.println(christmasGifts);

        assertEquals(
                2,
                new ProductService().countByFilter(
                        christmasGifts,
                        new BeginStringFilter("SALE")
                ),
                "Must determine the number of products starting with given characters"
        );
        assertEquals(
                1,
                new ProductService().countByFilter(
                        christmasGifts,
                        new ContainsFilter("Gift")
                ),
                "Must determine the number of products that have a given sequence of characters in their name"
        );
        assertEquals(
                2,
                new ProductService().countByFilter(
                        christmasGifts,
                        new UpperCaseFilter()
                ),
                "Should check if all product names consist of uppercase characters"
        );
    }

    @Test
    @DisplayName("3.2. Checking the countByFilterDeep method")
    void testCountByFilterDeep() {
        ProductsBatch christmasGifts1 = getProductsBatch1();
        ProductsBatch christmasGifts2 = getProductsBatch2();

        System.out.println(christmasGifts1);

        assertEquals(
                3,
                new ProductService().countByFilterDeep(
                        christmasGifts1,
                        new BeginStringFilter("SALE")
                ),
                "Must determine the number of products starting with given characters"
        );

        System.out.println(christmasGifts2);

        assertEquals(
                3,
                new ProductService().countByFilterDeep(
                        christmasGifts2,
                        new BeginStringFilter("SALE")
                ),
                "Must determine the number of products starting with given characters"
        );
    }

    @Test
    @DisplayName("3.3. Checking the checkAllWeighted method")
    void testCheckAllWeighted() {
        ProductsBatch christmasGifts1 = getProductsBatch1();
        ProductsBatch christmasGifts2 = getProductsBatch3();

        System.out.println(christmasGifts1);

        assertFalse(
                new ProductService().checkAllWeighted(christmasGifts1),
                "Must check whether all goods in the method are by weight"
        );

        System.out.println(christmasGifts2);

        assertTrue(
                new ProductService().checkAllWeighted(christmasGifts2),
                "Must check whether all goods in the method are by weight"
        );
    }

    private static ProductsBatch getProductsBatch1() {
        PackedItemizedProduct christmasTreeDecorationsSet = new PackedItemizedProduct(
                SALE_TREE,
                5,
                smallPack
        );
        PackedWeightProduct christmasTeaSet = new PackedWeightProduct(
                SALE_TEE,
                50,
                mediumPack
        );
        PackedSetProducts bigGiftBox = new PackedSetProducts(
                "Christmas Gift Box",
                new PackedProduct[]{christmasTreeDecorationsSet, christmasTeaSet},
                bigPack
        );

        return new ProductsBatch(
                "A batch of products with Christmas gifts",
                new PackedProduct[]{christmasTreeDecorationsSet, christmasTeaSet, bigGiftBox}
        );
    }

    private static ProductsBatch getProductsBatch2() {
        PackedItemizedProduct christmasTreeDecorationsSet = new PackedItemizedProduct(
                SALE_TREE,
                5,
                smallPack
        );
        PackedWeightProduct christmasTeaSet = new PackedWeightProduct(
                SALE_TEE,
                50,
                mediumPack
        );
        PackedSetProducts bigGiftBox1 = new PackedSetProducts(
                "Christmas Gift Box",
                new PackedProduct[]{christmasTreeDecorationsSet, christmasTeaSet},
                bigPack
        );
        PackedSetProducts bigGiftBox2 = new PackedSetProducts(
                "Christmas Gift Box",
                new PackedProduct[]{},
                bigPack
        );

        return new ProductsBatch(
                "A batch of products with Christmas gifts",
                new PackedProduct[]{christmasTreeDecorationsSet, christmasTeaSet, bigGiftBox1, bigGiftBox2}
        );
    }

    private static ProductsBatch getProductsBatch3() {
        PackedWeightProduct christmasTeaSet = new PackedWeightProduct(
                SALE_TEE,
                50,
                mediumPack
        );
        PackedSetProducts bigGiftBox1 = new PackedSetProducts(
                "Christmas Gift Box",
                new PackedProduct[]{christmasTeaSet, christmasTeaSet, christmasTeaSet},
                bigPack
        );
        PackedSetProducts bigGiftBox2 = new PackedSetProducts(
                "Christmas Gift Box",
                new PackedProduct[]{christmasTeaSet},
                bigPack
        );

        return new ProductsBatch(
                "A batch of products with Christmas gifts",
                new PackedProduct[]{christmasTeaSet, bigGiftBox1, bigGiftBox2}
        );
    }
}