import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountCalculatorTest {
    DiscountCalculator discountCalculator;

    @BeforeEach
    void setUp() {
        this.discountCalculator = new DiscountCalculator();
    }

    // R1
    @Test
    void givenNoMembership_whenCalculateDiscount_thenZeroDiscount() {
        MembershipLevel membershipLevel = MembershipLevel.NONE;
        double originalPrice = 50;

        double actualDiscountedPrice = discountCalculator.calculateFinalPrice(originalPrice, membershipLevel);
        assertEquals(originalPrice, actualDiscountedPrice);
    }

    // R2
    @Test
    void givenSilverMembership_whenCalculateDiscount_thenFivePercentDiscount() {
        MembershipLevel membershipLevel = MembershipLevel.SILVER;
        double originalPrice = 150;

        double expectedDiscountedPrice = originalPrice * 0.95;

        double actualDiscountPrice = discountCalculator.calculateFinalPrice(originalPrice, membershipLevel);
        assertEquals(expectedDiscountedPrice, actualDiscountPrice);
    }

    // R3
    @Test
    void givenGoldMembership_WhenCalculateDiscount_thenTenPercentDiscount() {
        MembershipLevel membershipLevel = MembershipLevel.GOLD;
        double originalPrice = 75;

        double expectedDiscountedPrice = originalPrice * 0.90;

        double actualDiscountedPrice = discountCalculator.calculateFinalPrice(originalPrice, membershipLevel);
        assertEquals(expectedDiscountedPrice, actualDiscountedPrice);
    }

    // R4
    @Test
    void givenPlatinumMembership_whenCalculateDiscount_thenTwentyPercentDiscount() {
        MembershipLevel membershipLevel = MembershipLevel.PLATINUM;
        double originalPrice = 200;

        double expectedDiscountPrice = originalPrice * 0.80;

        double actualDiscountPrice = discountCalculator.calculateFinalPrice(originalPrice, membershipLevel);
        assertEquals(expectedDiscountPrice, actualDiscountPrice);
    }

    // R5
    @Test
    void givenSilverMembershipAndPrice99Point99_whenCalculateDiscount_thenZeroDiscount() {
        MembershipLevel membershipLevel = MembershipLevel.SILVER;
        double originalPrice = 99.99;

        double actualDiscountedPrice = discountCalculator.calculateFinalPrice(originalPrice, membershipLevel);
        assertEquals(originalPrice, actualDiscountedPrice);
    }

    // R6
    @Test
    void givenSilverMembershipAndPrice100_whenCalculateDiscount_thenZeroDiscount() {
        MembershipLevel membershipLevel = MembershipLevel.SILVER;
        double originalPrice = 100;

        double actualDiscountedPrice = discountCalculator.calculateFinalPrice(originalPrice, membershipLevel);
        assertEquals(originalPrice, actualDiscountedPrice);
    }

    // R7
    @Test
    void givenSilverMembershipAndPrice100Point01_whenCalculateDiscount_thenFivePercentDiscount() {
        MembershipLevel membershipLevel = MembershipLevel.SILVER;
        double originalPrice = 100.01;

        double expectedDiscountPrice = originalPrice * 0.95;
        double actualDiscountPrice = discountCalculator.calculateFinalPrice(originalPrice, membershipLevel);
        assertEquals(expectedDiscountPrice, actualDiscountPrice);
    }

    // R8
    @Test
    void givenGoldMembershipAndPrice49Point99_whenCalculateDiscount_thenZeroPercentDiscount() {
        MembershipLevel membershipLevel = MembershipLevel.GOLD;
        double originalPrice = 49.99;

        double actualDiscountPrice = discountCalculator.calculateFinalPrice(originalPrice, membershipLevel);
        assertEquals(originalPrice, actualDiscountPrice);
    }

    // R9
    @Test
    void givenSilverMembershipAndPrice50_whenCalculateDiscount_thenZeroPercentDiscount() {
        MembershipLevel membershipLevel = MembershipLevel.GOLD;
        double originalPrice = 50;

        double actualDiscountPrice = discountCalculator.calculateFinalPrice(originalPrice, membershipLevel);
        assertEquals(originalPrice, actualDiscountPrice);
    }

    // R10
    @Test
    void givenGoldMembershipAndPrice51Point01_whenCalculateDiscount_thenZeroPercentDiscount() {
        MembershipLevel membershipLevel = MembershipLevel.GOLD;
        double originalPrice = 50.01;

        double expectedDiscountPrice = originalPrice * 0.90;

        double actualDiscountPrice = discountCalculator.calculateFinalPrice(originalPrice, membershipLevel);
        assertEquals(expectedDiscountPrice, actualDiscountPrice);
    }
}

