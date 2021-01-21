<template>
    <div>
        <my-header v-bind:cartItemCount="cartItemCount"></my-header>
        <main class="jumbotron">
            <div v-for="product in sortedProducts" v-bind:key="product.id">
                <div class="row">
                    <div class="col-6">
                        <figure>
                            <img :src="product.image" class="product">
                            <!-- <img v-bind:src="product.image" class="product"> -->
                        </figure>
                    </div>
                    <div class="col-6">
                        <!-- <h1>{{ product.title }}</h1> -->
                        <router-link tag="h1"
                            :to="{name: 'Id', params: {id: product.id}}">
                            {{product.title}}
                        </router-link>
                        <p v-html="product.description"></p>
                        <p class="price">{{ product.price | formatPrice }}</p>
                        <!-- <button class="btn btn-primary" v-on:click="addToCart(product)" v-show="canAddToCart(product)">Add to cart</button> -->
                        <!-- <button class="btn btn-primary" @click="addToCart(product)" v-show="canAddToCart(product)">Add to cart</button> -->
                        <button class="btn btn-primary" v-on:click="addToCart(product)" v-if="canAddToCart(product)">Add
                            to
                            cart</button>
                        <button class="btn btn-primary disabled" v-else>Add to cart</button>
                        <transition name="bounce" mode="out-in">
                            <span class="inventory-message"
                                v-if="product.availableInventory - cartCount(product.id) === 0"
                                key="0">All
                                out!</span>
                            <span class="inventory-message"
                                v-else-if="product.availableInventory - cartCount(product.id) < 5"
                                key="">Only
                                {{ product.availableInventory - cartCount(product.id) }} left!</span>
                            <span class="inventory-message" v-else
                                key="">Buy now!</span>
                        </transition>

                        <div class="rating">
                            <span v-for="n in 5" class="fa-star" v-bind:key="n"
                                v-bind:class="{'fas': checkRating(n, product), 'far': !checkRating(n, product)}"></span>
                        </div>
                    </div>
                </div>
                <hr>
            </div>
        </main>
    </div>
</template>

<script>
import MyHeader from './Header.vue';
import axios from 'axios';

function compare(a, b) {
    if (a.rating > b.rating)
        return -1;
    if (a.rating < b.rating)
        return 1;
    return 0;
}

export default {
    name: 'iMain',
    data() {
        return {
            products: [],
            cart: [],
        };
    },
    components: {MyHeader},
    methods: {
        checkRating(n, product) {
            return product.rating - n >= 0;
        },
        addToCart(product) {
            this.cart.push(product.id);
        },
        canAddToCart(product) {
            return product.availableInventory > this.cartCount(product.id);
        },
        cartCount(id) {
            let count = 0;
            for (var i = 0; i < this.cart.length; i++) {
                if (this.cart[i] === id)
                    count++;
            }
            return count;
        },

    },
    computed: {
        cartItemCount() {
            return this.cart.length || '';
        },
        sortedProducts() {
            if (this.products.length > 0) {
                let productsArray = this.products.slice(0);
                return productsArray.sort(compare);
            }
            return null;
        },
    },
    filters: {
        formatPrice(price) {
            if (!parseFloat(price))
                return "";

            var priceArray = String(price).split("").reverse();
            var index = 0;

            while (priceArray.length > index + 3) {
                priceArray.splice(index + 3, 0, " ");
                index += 4;
            }

            return priceArray.reverse().join("") + " ₽";
        }
    },
    created() {
        axios.get('/products.json')
            .then((response) => {
                this.products = response.data.products;
            })
    },
}
</script>

<style scoped>
/* Styles */
img.product {
    height: auto;
    width: 300px;
    border-radius: 10px;
}

.price {
    font-weight: bold;
}

.inventory-message {
    font-weight: bold;
    padding-left: 30px;
}

.rating {
    padding-top: 30px;
}

/* Animation */
.bounce-enter-active {
    animation: shake 0.72s cubic-bezier(.37, .07, .19, .97) both;
    transform: translate3d(0, 0, 0);
    backface-visibility: hidden;
}

@keyframes shake {
    10%, 90% {
        color: red;
        transform: translate3d(-1px, 0, 0);
    }    
    20%, 80% {
        transform: translate3d(2px, 0, 0);
    }
    30%, 50%, 70% {
        color: red;
        transform: translate3d(-4px, 0, 0);
    }
    40%, 60% {
        transform: translate3d(4px, 0, 0);
    }
}
</style>
