<template>
    <header>
        <div class="navbar navbar-light bg-light">
            <a href="#" class="navbar-brand mb0 h1">
                <router-link v-bind:to="{name: 'iMain'}">
                    {{sitename}}
                </router-link>
            </a>
            <button class="btn btn-secondary" v-on:click="showCheckout">
                {{ cartItemCount }}
                <span class="fas fa-shopping-cart"></span>
                Checkout
            </button>
        </div>
    </header>
</template>

<script>
export default {
    name: 'my-header',
    data: {
        sitename: "Vue.js Pet Depot"
    },
    props: ["cartItemCount"],
    methods: {
        showCheckout() {
            this.$router.push({name: 'Form'});
        }
    }
}
</script>

<style scoped>
a {
    text-decoration: none;
    color: black;
}
</style>