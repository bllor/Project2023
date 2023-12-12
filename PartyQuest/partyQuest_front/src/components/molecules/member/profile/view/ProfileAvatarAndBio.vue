<script setup>

import ProfileImg from "@/components/atoms/member/profile/ProfileImg.vue";
import {ref} from "vue";
import ProfileFields from "@/components/atoms/member/profile/ProfileFields.vue";
import {useProfileStore} from "@/stores/memberProfileStore";

let profileStore = useProfileStore();
const bio = ref("안녕하세요 선생님 우리모두 춤춰요\n안녕 친구야\nㅎㅏ\nㅎㅏ\nㅎㅏ\nㅎㅏ")
</script>

<template>
  <div class="out-container">
    <div class="thumb-container">
      <ProfileImg/>
    </div>
    <div class="name-bio-container">
      <div class="name-div">{{profileStore.getProfileInfo().value.nickName}}</div>
      <div class="bio-fluid-container">
        <div class="bio-div">{{profileStore.getProfileInfo().value.bio}}</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.out-container {
  display: flex;
  width: 100%;
}
.thumb-container {
  border-radius: 100%;
}
.thumb-container img{
  object-fit: fill;
  width: 8rem;
  height: 8rem;
}
.name-bio-container{
  padding-top: .5rem;
  padding-left: .4rem;
  height:8rem;
  overflow-y:hidden;
}
.name-div{
  font-size:2rem;
}
.bio-fluid-container{
  height: 4.5rem;
  overflow-y: scroll;
}
.bio-div{
  white-space: pre;
  color:dimgray;

}
</style>