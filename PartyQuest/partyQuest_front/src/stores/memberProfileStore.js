import {defineStore} from "pinia";
import {ref} from "vue";

export const useProfileStore = defineStore('profileStore',()=>{
    const fetchCnt = ref(0);
    const profileInfo =ref({
        nickName:'',
        bio:'',
        preferredLocation: '부산특별시',
        mbti: 'INTJ',
        favoriteFields: new Set([]),
        favoriteTechs: new Set([]),
        link1:'',
        link2:''
    })
    const tmpProfileInfo =ref({
        nickName:'',
        bio:'',
        preferredLocation: '부산특별시',
        mbti: 'INTJ',
        favoriteFields: new Set([]),
        favoriteTechs: new Set([]),
        link1:'',
        link2:''
    })
    const getProfileInfo = ()=>{
        return profileInfo;
    }
    const getTmpProfileInfo = ()=>{
        return tmpProfileInfo;
    }
    const getTmpNickName = ()=>{
        return tmpProfileInfo.value.nickName;
    }
    const addField = (field)=>{
        tmpProfileInfo.value.favoriteFields.add(field);
    }
    const addTech = (tech)=>{
        tmpProfileInfo.value.favoriteTechs.add(tech);
    }
    const setTmpLocation = (val)=>{
        tmpProfileInfo.value.preferredLocation = val;
    }
    const setTmpMbti = (val)=>{
        tmpProfileInfo.value.mbti = val;
    }
    const setTmpNickName = (name)=>{
        tmpProfileInfo.value.nickName = name;
    }
    const setTmpNickbio = (bio)=>{
        tmpProfileInfo.value.bio = bio;
    }
    const setTmplink1 = (link)=>{
        tmpProfileInfo.value.link1 = link;
    }
    const setTmplink2 = (link)=>{
        tmpProfileInfo.value.link2 = link;
    }
    const setProfileInfo = (info) => {
        profileInfo.value = info;
    };
    return {
        addField,addTech,getProfileInfo,
        getTmpProfileInfo,getTmpNickName,setTmpNickName,setTmpNickbio
        ,setTmplink1,setTmplink2,setTmpLocation,setTmpMbti,setProfileInfo
    }
})