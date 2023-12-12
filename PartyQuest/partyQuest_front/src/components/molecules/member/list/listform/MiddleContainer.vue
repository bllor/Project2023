<template>
  <div class="cate-container">
    <div v-for="cate in props.cateList" :key="cate.id">
      <MemberMiddleCate :cate-name="cate.name" :key="cate.id"/>
    </div>
  </div>
</template>

<script setup>
import MemberMiddleCate from "@/components/molecules/member/list/listform/MemberMiddleCate.vue";
const props = defineProps({
  cateList: Array,
  cateKind: String
});
</script>