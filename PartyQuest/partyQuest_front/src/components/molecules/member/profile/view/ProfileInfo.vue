<script setup>

import ProfileAvatarAndBio from "@/components/molecules/member/profile/view/ProfileAvatarAndBio.vue";
import ProfileFields from "@/components/atoms/member/profile/ProfileFields.vue";
import ProfileAvatarAndBioEdit from "@/components/molecules/member/profile/modify/ProfileAvatarAndBioEdit.vue";
import {useRouter} from "vue-router";
import {onMounted, ref} from "vue";
import ProfileUpdateFields from "@/components/atoms/member/profile/ProfileUpdateFields.vue";
import {useProfileStore} from "@/stores/memberProfileStore";
import {useAuthStore} from "@/stores/authStore";
import {getPartyLocationForUpdateProfile, getProfile} from "@/utils/fetch/memberFetch";

const router = useRouter();
const props = defineProps({
  state: String
});
let authStore = useAuthStore();
let profileStore = useProfileStore();
const updateRequest = ref({
  nickName: '',
  bio: '',
  favoriteLocation:'',
  mbti:'',
  favoriteFields: [],
  favoriteTechs:[],
  links:[]
})

const onModifyRouteBtnClick = ()=>{
  router.push('/profile/update');
}
const onModifyBtnClick = ()=>{

}
const onCancelBtnClick = ()=>{
  router.push('/profile')
}
const onValid = ()=>{
  console.log(profileStore.getTmpProfileInfo().value)
}
onMounted(async ()=>{
  let profile = await getProfile(authStore.getAccessToken());
  profileStore.setProfileInfo(profile);
})
</script>

<template>
  <div v-if="props.state === 'modify'" class="profile-main-container">
    <ProfileAvatarAndBioEdit
    @nick-name="nick=> updateRequest.nickName=nick"
    @bio = "bio=>updateRequest.bio=bio"
    />
    <ProfileUpdateFields/>
    <div class="btn-container">
      <div class="myBtn" @click="onModifyBtnClick">업데이트</div>
      <div class="myBtn cancel-btn" @click="onCancelBtnClick">취소하기</div>
      <div class="myBtn cancel-btn" @click="onValid">확인</div>
    </div>

  </div>
  <div v-else class="profile-main-container">
    <ProfileAvatarAndBio/>
    <ProfileFields/>
    <div class="btn-container">
      <div class="myBtn" @click="onModifyRouteBtnClick">프로필 수정하기</div>
    </div>
  </div>
</template>

<style scoped>
.profile-main-container{
  padding-left: 2rem;
}
.btn-container{
  margin-left:2rem;
  display:flex;
  gap: .3rem;
}
.myBtn {
  cursor: pointer;
  display: inline-flex;
  justify-content: center;
  align-items: center;
  padding: 0.2rem 0.5rem;
  background: #3c4142;
  color: white;
  border-radius: 0.4rem;
  font-size: 1.2rem;
}
.cancel-btn{
  background: #a9333e;
}
.route-to-modify:hover{
  cursor:pointer;
  background: dimgrey;
}
</style>