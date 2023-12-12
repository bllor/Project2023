<script setup>
import {ref, defineProps, onMounted} from "vue";
import IconSearch from "@/components/icons/IconSearch.vue";
import MemberBox from "@/components/molecules/member/list/listform/MemberBox.vue";
import Banner from "@/components/molecules/board/Banner.vue";
import { useRouter } from "vue-router";
import Paging from "@/components/molecules/study/list/Paging.vue";
import {getPagedMembers} from "@/utils/fetch/memberFetch";
import {useCateStore} from "@/stores/cateStore";
import {getLocations} from "@/utils/fetch/studyFetch";

const router = useRouter();
const props = defineProps({
  middleCateId: Number,
  smallCateIds: Number,
  curMajorKeySet: String,
  curMiddleKeySet: String
});

const curKey = ref({
  major: "",
  middle: ""
});
const isFirstFetched = ref(false);
const dataFetchFlag = ref(0);
const searchCond = ref({
  middleCateId: props.middleCateId,
  smallCateIds: isNaN(props.smallCateIds)? new Set() : new Set([String(props.smallCateIds)]),
  page: null,
  title: null,
  sort: null
})
const pageData = ref({});
const cateStore = useCateStore();
const smallCates = ref(null)
/// 지역 리스트 ///
const selectedLocation = ref("지역 선택");
const locations = ref([]);
const fetchLocations = async () => {
  try {
    const res = await getLocations();
    locations.value = res;
  } catch (error) {
    console.error(error);
  }
};

//// 페이징 ////
const onPagingHandler = (num)=>{
  isFirstFetched.value = false;
  searchCond.value.page = num;
  console.log('아콩이',searchCond.value, dataFetchFlag.value,pageData.value)
}
onMounted(async ()=>{
  //console.log('내가 요청하는 params',searchCond.value)
  pageData.value = await getPagedMembers();
  console.log("PAGE DATA"+ JSON.stringify(pageData.value));
/*  if(isNaN(searchCond.value.middleCateId)){

  }else{
    //pageData.value = await searchStudy(searchCond.value);
  }*/

})
</script>
<template>
  <Banner title="파티퀘스트에는 어떤 파티원들이 있을까요?" subTitle="다양한 파티원을 찾고, 직접 채팅까지!" />
  <main class="grid-container">
    <div class="peopleSearchOption">
      <h1>
        <span class="smTxt">파티크루</span>
        <span class="bgTxt">파티원 찾기</span>
      </h1>
      <div class="peopleSearchOption">
        <div class="flex-container">
          <div class="optionWrap">
            <select class="dropdown1">
              <option>지역</option>
              <option>온라인</option>
              <option>서울</option>
              <option>부산</option>
            </select>
            <select class="dropdown2">
              <option>관심 기술</option>
              <option>프론트</option>
              <option>백엔드</option>
            </select>
          </div>
          <div class="inputSearch">
            <input class="searchBox" type="text" placeholder="ex)닉네임, 상세 스킬명" maxlength="10">
            <button class="buttonComponents">
              <IconSearch></IconSearch>
            </button>
          </div>
        </div>
      </div>
    </div>
    <div class="memberGrid" >
      <div v-for="data in pageData.content" >
        <MemberBox :member-info="data" class="memberComponent"></MemberBox>
      </div>
    </div>
    <div v-if='pageData!==null' class="paging-container">
      <div class="paging-wrapper">
        <Paging v-for="num in pageData.totalPages" :pg="num"
                @click="onPagingHandler(num)"/>
      </div>
    </div>
  </main>
</template>
<style scoped>
.grid-container{
  display: grid;
  grid-gap: 20px 10px;
  grid-template-columns: repeat(4, 1fr);
}
.peopleSearchOption{
  grid-column: 2 / 3;
}
h1 span{
  display: block;
}
.flex-container{
  display: flex;
}

.optionWrap{
  text-align: center;
  display: flex;
}
.inputSearch {
  display: flex;
}
.dropdown1,
.dropdown2 {
  display: inline-block;
  margin-right: 10px;
  width: 100px;
  border: 1px solid darkgray;
}
.memberGrid{
  margin-top: 20px;
  margin-bottom: 100px;
  display: grid;
  height:auto;
  grid-template-columns: repeat(auto-fit, minmax(285px,1fr));
  grid-template-rows: repeat(4, 1fr);
  grid-column: 2 / 4;
  gap: 10px;
}
.smTxt {
  margin-top: 50px;
  margin-bottom: 4px;
  font-size: 18px;
  color: tomato;
}
.bgTxt{
  font-size: 32px;
}
.searchBox {
  border: 1px solid darkgray;
  border-radius: 2px;
  height: 35px;
  width: 250px;
}

.paging-container {
  grid-column: span 4;
  margin: 20px 0px;
  place-items: center center;
  gap: 10px;
}
.paging-wrapper {
  display: flex;
  justify-content: center;
  gap: 3px;
}
</style>
