<template>
    <header>
        <div class="navbar navbar-light bg-light">
            <a href="#" class="navbar-brand mb0 h1">
                <router-link v-bind:to="{name: 'iMain'}">
                    {{sitename}}
                </router-link>
            </a>
            <router-link
                active-class="active"
                tag="button"
                class="btn btn-secondary"
                :to="{name: 'Form'}">
                {{ cartItemCount }}
                <span class="fas fa-shopping-cart"></span>
                Checkout
            </router-link>
        </div>
    </header>
</template>

<script>
export default {
    name: 'my-header',
    data() {
        return {
            sitename: "Vue.js Pet Depot"
        };
    },
    props: ["cartItemCount"],
}
</script>

<style scoped>
a {
    text-decoration: none;
    color: black;
}

.router-link-exact-active {
    /* Active el style */
    color: black;
    /* color: darkgray; */
}
</style>