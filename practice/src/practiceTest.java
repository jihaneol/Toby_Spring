import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class practiceTest {

    private ProductService productservice;

    @BeforeEach
    void setUp() {
        productservice = new ProductService();
    }
    @Test
    @DisplayName("주문해보자")
    void order() throws Exception {
        // given
        final AddProductRequest request = getAddProductRequest();
        productservice.addProduct(request); 
        //when

        //then

    }

    private static AddProductRequest getAddProductRequest() {
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final String name = "상품명";
        final int price = 1000;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        return request;
    }

}
