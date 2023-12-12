<script setup>
import {ref} from "vue";

const DEFAULT_AVATAR_URL = '/img/profile_simple.png'
const props = defineProps({
  content: String
});
const myImgProp = ref({
  src: (props.content === undefined || props.content===null) ? DEFAULT_AVATAR_URL : import.meta.env.VITE_APP_BASE_RESOURCE_URL + props.content,
});
</script>

<template>
  <img :src="myImgProp.src"/>
</template>

<style scoped>

</style>