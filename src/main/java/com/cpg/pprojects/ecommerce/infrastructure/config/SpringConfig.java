package com.cpg.pprojects.ecommerce.infrastructure.config;

import com.cpg.pprojects.ecommerce.domain.address.repository.IAddressRepository;
import com.cpg.pprojects.ecommerce.domain.cart.repository.ICartRepository;
import com.cpg.pprojects.ecommerce.domain.cartItem.repository.ICartItemRepository;
import com.cpg.pprojects.ecommerce.domain.product.repository.IProductRepository;
import com.cpg.pprojects.ecommerce.domain.user.repository.IUserRepository;
import com.cpg.pprojects.ecommerce.usecase.address.*;
import com.cpg.pprojects.ecommerce.usecase.cart.*;
import com.cpg.pprojects.ecommerce.usecase.common.ITransactionRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    //Address
    @Bean
    public CreateAdressUseCase createAdressUseCase(IAddressRepository addressRepository) {
        return new CreateAdressUseCase(addressRepository);
    }
    @Bean
    public DeleteAddressUseCase deleteAddressUseCase(IAddressRepository addressRepository) {
        return new DeleteAddressUseCase(addressRepository);
    }
    @Bean
    public GetAddressByIdUseCase getAddressByIdUseCase(IAddressRepository addressRepository) {
        return new GetAddressByIdUseCase(addressRepository);
    }
    @Bean
    public GetAddressesUseCase getAddressesUseCase(IAddressRepository addressRepository) {
        return new GetAddressesUseCase(addressRepository);
    }
    @Bean
    public GetUserAddressesUseCase  getUserAddressesUseCase(IAddressRepository addressRepository) {
        return new GetUserAddressesUseCase(addressRepository);
    }
    @Bean
    public UpdateAddressUseCase updateAddressUseCase(IAddressRepository addressRepository, IUserRepository userRepository) {
        return new UpdateAddressUseCase(addressRepository,  userRepository);
    }

    //Cart
    @Bean
    public AddProductToCartUseCase addProductToCartUseCase(
            ICartRepository cartRepository,
            IProductRepository productRepository,
            ICartItemRepository cartItemRepository
    ) {
        return new AddProductToCartUseCase(cartRepository, productRepository, cartItemRepository);
    }
    @Bean
    public CreateOrUpdateCartWithItemsUseCase createOrUpdateCartWithItemsUseCase(
            ICartRepository cartRepository,
            ICartItemRepository cartItemRepository,
            IProductRepository productRepository,
            ITransactionRunner transactionRunner
    ) {
        return new CreateOrUpdateCartWithItemsUseCase(cartRepository, cartItemRepository, productRepository, transactionRunner);
    }
    @Bean
    public DeleteProductFromCartUseCase deleteProductFromCartUseCase(
            ICartRepository cartRepository,
            ICartItemRepository cartItemRepository,
            ITransactionRunner transactionRunner
    ) {
        return new DeleteProductFromCartUseCase(cartRepository, cartItemRepository, transactionRunner);
    }
    @Bean
    public GetAllCartsUseCase getAllCartsUseCase(ICartRepository cartRepository, ICartItemRepository cartItemRepository) {
        return new GetAllCartsUseCase(cartRepository, cartItemRepository);
    }
    @Bean
    public GetCartByEmailUseCase getCartByEmailUseCase(ICartRepository cartRepository, ICartItemRepository cartItemRepository) {
        return new GetCartByEmailUseCase(cartRepository, cartItemRepository);
    }
    @Bean
    public UpdateProductInCartsUseCase updateProductInCartsUseCase(
            ICartRepository cartRepository,
            IProductRepository productRepository,
            ICartItemRepository  cartItemRepository
    ) {
        return new UpdateProductInCartsUseCase(cartRepository, productRepository, cartItemRepository);
    }
    @Bean
    public UpdateProductQuantityInCartUseCase updateProductQuantityInCartsUseCase(
            ICartRepository cartRepository,
            IProductRepository productRepository,
            ICartItemRepository cartItemRepository,
            ITransactionRunner transactionRunner
    ) {
        return new UpdateProductQuantityInCartUseCase(cartRepository, productRepository, cartItemRepository, transactionRunner);
    }
}
