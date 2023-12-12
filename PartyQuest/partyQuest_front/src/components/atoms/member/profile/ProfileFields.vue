<script setup>
import HashTagDiv from "@/components/atoms/member/profile/HashTagDiv.vue";
import IconLink from "@/components/icons/IconLink.vue";
import {useProfileStore} from "@/stores/memberProfileStore";

let profileStore = useProfileStore();
</script>

<template>
  <div class="profile-fields-container">
  <div class="profile-field-container">
    <div class="field-name-div">선호지역</div>
    <div class="field-content-div">{{profileStore.getProfileInfo().value.preferredLocation}}</div>
  </div>
  <div class="profile-field-container">
    <div class="field-name-div">MBTI</div>
    <div class="field-content-div">{{profileStore.getProfileInfo().value.mbti}}</div>
  </div>
  <div class="profile-field-container">
    <div class="field-name-div">나의 관심 분야</div>
    <div class="field-content-div">
      <HashTagDiv v-for="field in profileStore.getProfileInfo().value.favoriteFields" :value="field" color="white" background-color="#008B8B"/>
    </div>
  </div>
  <div class="profile-field-container">
    <div class="field-name-div">나의 관심 기술</div>
    <div class="field-content-div">
      <HashTagDiv v-for="field in profileStore.getProfileInfo().value.favoriteTechs" :value="field" color="white" background-color="#1CAC78"/>
    </div>
  </div>
    <div class="profile-field-container">
      <div class="field-name-div">포트폴리오/URL</div>
      <div class="field-content-div">
        <div>
          <IconLink/>
        </div>
        <div>
          <IconLink/>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.profile-fields-container{
  padding-top: 1rem;
  padding-left:2rem;
}
.profile-field-container{
  border-top: solid 1px rgba(128, 128, 128, 0.5);
  margin-bottom: 1.5rem;
  padding-top: .3rem;
}
.field-name-div{
  font-weight: 600;
  font-size:1.2rem;
  margin-bottom: .5rem;
}
</style>