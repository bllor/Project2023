import {axiClient, axiValid, getValidatedAxios} from "@/utils/globalAxios";
import {URLCONST} from "@/constants/APIconst";
import {AUTH_CONST} from "@/constants/authConst";

const SMALL_CATE_IDS = 'smallCateIds';
export const getLocations = ()=>{
    return axiClient.get(URLCONST.STUDY_LOCATIONS)
        .then(res=> res.data)
}

export const getPagedMembers = async ()=>{
    return await axiClient.get(`${URLCONST.MEMBER_LIST}`
    )
        .then(res=>{
            console.log(res.data);
            return res.data;
        }).catch(err => console.log(err))
}
export const searchStudy = async(params)=>{
    let smallCates = Array.from(params[SMALL_CATE_IDS]);
    let copiedParams = {...params};
    copiedParams[SMALL_CATE_IDS] = [...smallCates];
    console.log('copied params : ',copiedParams[SMALL_CATE_IDS])
    let searchParams = makeQueryString(copiedParams);
    console.log('후처리 됐냐?',copiedParams,'쿼리 스트링 : ',searchParams.toString());
    return await axiClient.get(`${URLCONST.MEMBER_LIST}?${searchParams.toString()}`
    )
        .then(res=>{
            console.log(res.data);
            return res.data;
        }).catch(err => console.log(err))
};

export const getPartyLocationForUpdateProfile = async (accessToken) => {
    let validatedAxios = getValidatedAxios(accessToken);
    return await validatedAxios.get(URLCONST.PARTY_LOCATION_LIST)
        .then(res => res.data);
};
export const getMbtis = async (accessToken) => {
    let validatedAxios = getValidatedAxios(accessToken);
    return await validatedAxios.get(URLCONST.MBTI_LIST)
        .then(res => res.data);
};

export const getProfile = async (accessToken) => {
    return await axiValid.get(URLCONST.PROFILE_GET, {
        headers: {
            Authorization: AUTH_CONST.AUTH_BEARER + accessToken,
            'Content-type': 'application/json; charset=UTF-8',},
    })
        .then(res => res.data);
};

const makeQueryString = (obj) => {
    for (const key of Object.keys(obj)) {
        if (obj[key] === null || obj[key].length === 0) {
            delete obj[key];
        }
    }
    const tmpObj = {...obj};
    delete tmpObj[SMALL_CATE_IDS];
    const myQueryString = new URLSearchParams(tmpObj);
    if (obj[SMALL_CATE_IDS] !== undefined) {
        if (obj[SMALL_CATE_IDS].length > 1) {
            for (const smallIds of obj[SMALL_CATE_IDS]) {
                myQueryString.append(SMALL_CATE_IDS, smallIds);
            }
        }else{
            myQueryString.set(SMALL_CATE_IDS, obj[SMALL_CATE_IDS][0]);
        }
    }
    return myQueryString;
}
