package phoenix.partyquest.repository.member;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import phoenix.partyquest.domain.member.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom {
    //동한
    public Optional<Member> findByEmail(String email);
    @Query("select m from Member m left join m.profile mp left join mp.favoriteMiddles mpm left join mp.favoriteSmalls mps left join mp.preferredLocation mpl where m.id=:id")
    public Optional<Member> findMemberByIdWithProfile(Long id);
    @Query("select m from Member m left join m.profile mp left join mp.favoriteMiddles mpm left join mp.favoriteSmalls mps left join mp.preferredLocation mpl where m.email=:email")
    public Optional<Member> findMemberByEmailWithProfile(@Param("email") String email);
    //동한 끝

    //경진

    //경진 끝
    //현정
    @Query("select m from Member m left join m.likedStudyList ls left join ls.study lss where m.id = :id")
    public Optional<Member> findMemberWithStudyListById(@Param("id") Long id);

    public int countByEmail(String eString);

    public Optional<Member> findByLoginId(String loginId);
    //현정 끝
    //동일
    @Query("select m from Member m left join m.profile mp where m.email = :id")
    public Optional<Member> findMemberWithProfileById(@Param("id") String id);
    //동일 끝




}
