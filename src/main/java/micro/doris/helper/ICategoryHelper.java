package micro.doris.helper;

import micro.doris.entity.User;
import micro.doris.to.ProductCategory;
import micro.doris.viewmodel.UserModel;

import java.util.List;

public interface ICategoryHelper {
    List<ProductCategory> getProductsWithCategoryName();
}
