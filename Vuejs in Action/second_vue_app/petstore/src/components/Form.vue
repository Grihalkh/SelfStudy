<template>
    <div>
        <my-header v-bind:cartItemCount="cartItemCount"></my-header>
        <div class="jumbotron">
        <div class="form-row">
            <div class="form-group col-6">
                <strong>First name:</strong>
                <input v-model.trim.lazy="order.firstName" class="form-control" />
            </div>
            <div class="form-group col-6">
                <strong>Last name:</strong>
                <input v-model.trim.lazy="order.lastName" class="form-control" />
            </div>
            <div class="form-group col-12">
                <strong>Address:</strong>
                <input v-model.trim.lazy="order.address" class="form-control" />
            </div>
            <div class="form-group col-12">
                <strong>City:</strong>
                <input v-model.trim.lazy="order.city" class="form-control" />
            </div>
            <div class="form-row col-12">
                <div class="form-group col-2">
                    <strong>State:</strong>
                    <select v-model.lazy="order.state" class="form-control">
                        <option disabled value="">State</option>
                        <option v-for="(state, state_key) in states" 
                            v-bind:value="state"
                            v-bind:key="state_key">{{ state_key }}</option>
                    </select>
                </div>
                <div class="form-group col-6 offset-4">
                    <strong>Zip / Postal code:</strong>
                    <input v-model.number.lazy="order.zip" class="form-control" type="number" />
                </div>
            </div>
            <div class="form-row col-12">
                <div class="form-group col-6">
                    <input type="checkbox" id="gift" value="true" v-bind:true-value="order.sendGift"
                        v-bind:false-value="order.dontSendGift" v-model.lazy="order.gift" />
                    <label for="gift">Ship as a Gift?</label>
                </div>
                <div class="form-group col-6">
                    <input type="radio" id="home" value="Home" v-model.lazy="order.method" />
                    <label for="home">Home</label>
                    <input type="radio" id="business" value="Business" 
                        v-model.lazy="order.method" />
                    <label for="business">Business</label>
                </div>
            </div>
            <div class="form-group col-6">
                <button type="submit" class="btn btn-primary submit" v-on:click="submitForm">Place
                    order</button>
            </div>
            <div class="form-group col-12 verify">
                <pre>
                        First name: {{ order.firstName }}
                         Last name: {{ order.lastName }}
                           Address: {{ order.address }}
                              City: {{ order.city }}
                               Zip: {{ order.zip }}
                             State: {{ order.state }}
                            Method: {{ order.method }}
                              Gift: {{ order.gift }}
                    </pre>
            </div>
        </div>
        </div>
    </div>
</template>

<script>
import MyHeader from './Header.vue';
export default {
    name: 'Form',
    props: ['cartItemCount'],
    data() {
        return {
            states: {
                AL: "sweet home Alabama",
                AR: "Arizona",
                CA: "welcome to the hotel California",
                NV: "Nevada",
            },
            order: {
                firstName: "",
                lastName: "",
                address: "",
                city: "",
                zip: "",
                state: "",
                method: "Home address",
                home: "Home address",
                business: "Business address",
                gift: "Send as a Gift",
                sendGift: "Send as a Gift",
                dontSendGift: "Do not send as a Gift",
            },
        };
    },
    components: {MyHeader},
    methods: {
        submitForm() {
            alert('Submitted');
        }
    }
}
</script>