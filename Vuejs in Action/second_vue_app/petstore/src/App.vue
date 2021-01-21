<template>
  <div id="app">
    <transition name="fade" mode="out-in">
      <router-view/>
    </transition>
  </div>
</template>

<style scoped>
  .fade-enter-active, .fade-leave-active {
    transition: opacity .5s ease-out;
  }

  .fade-enter, .fade-leave-to {
    opacity: 0;
  }
</style>