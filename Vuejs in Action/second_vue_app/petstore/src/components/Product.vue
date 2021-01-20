<template>
    <div>
        <my-header></my-header>
        <div class="jumbotron">
            <h1> This is the id {{$route.params.id}}</h1>
            <div class="row">
                <div class="col-6">
                    <figure>
                        <img v-bind:src="product.image" class="product">
                    </figure>
                </div>
                <div class="col-6">
                    <h1>{{ product.title }}</h1>
                    <p v-html="product.description"></p>
                    <p class="price">{{ product.price }}</p>
                    <button v-on:click="edit"
                        class="btn btn-primary">Edit product</button>
                    <router-view></router-view>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import MyHeader from './Header.vue'
import axios from 'axios'

export default {
    components: {MyHeader},
    data () {
        return {
            product: ''
        };
    },
    created: function() {
        axios.get('/products.json').then(
            (response) => {
                this.product = response.data.products.filter(
                    data => data.id == this.$route.params.id)[0];
                this.product.image = '/' + this.product.image;
            }
        );
    },
    methods: {
        edit() {
            this.$router.push({name: 'Edit'});
        }
    }
    
}
</script>

<style scoped>
img.product {
    height: auto;
    width: 300px;
    border-radius: 10px;
}

.price {
    font-weight: bold;
}
</style>