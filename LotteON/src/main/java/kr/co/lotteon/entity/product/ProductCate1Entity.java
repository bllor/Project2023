package kr.co.lotteon.entity.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="km_product_cate1") // 테이블 명 lotte_~ 로 바꿀지 의견 나눠보기
public class ProductCate1Entity {

    @Id
    private int cate1;
    private String c1Name;

    @OneToMany(mappedBy = "prodCate1",cascade = CascadeType.ALL)
    private List<ProductEntity> products = new ArrayList<>();

    @OneToMany(mappedBy = "cate1",fetch = FetchType.LAZY)
    private List<ProductCate2Entity> cate2s = new ArrayList<>();

    public void addProduct(ProductEntity productEntity) {
        this.products.add(productEntity);
        productEntity.setProdCate1(this);
    }
}

cateTest Result : 
[
    MajorCate
    [id=1, name='프로그래밍', 
        middleCates=
        [
            MiddleCate
            [id=12, name='백앤드', 
                smallCates=
                [
                    SmallCate[id=1200, name='Spring'], 
                    SmallCate[id=1201, name='Java'], 
                    SmallCate[id=1202, name='Spring Boot'], 
                    SmallCate[id=1203, name='Node.js'], 
                    SmallCate[id=1204, name='AWS'], 
                    SmallCate[id=1205, name='JavaScript'], 
                    SmallCate[id=1206, name='JPA'], 
                    SmallCate[id=1207, name='Docker'], 
                    SmallCate[id=1208, name='Express'], 
                    SmallCate[id=1209, name='MongoDB'], 
                    SmallCate[id=1210, name='Python']
                ]
            ],
            MiddleCate
            [id=11, name='프론트앤드', 
                smallCates=
                [
                    SmallCate[id=1100, name='JavaScript'], 
                    SmallCate[id=1101, name='HTML/CSS'], 
                    SmallCate[id=1102, name='React'], 
                    SmallCate[id=1103, name='Vue.js'], 
                    SmallCate[id=1104, name='jQuery'], 
                    SmallCate[id=1105, name='TypeScript'], 
                    SmallCate[id=1106, name='ES6'], 
                    SmallCate[id=1107, name='Node.js'], 
                    SmallCate[id=1108, name='Next.js'], 
                    SmallCate[id=1109, name='웹앱'], 
                    SmallCate[id=1110, name='Redux']
                ]
            ]
        ]
    ]
]

[
    MajorCate
    [
        id=1, name='프로그래밍', 
        middleCates=
        [
            MiddleCate
            [
                id=11, name='프론트앤드', 
                smallCates=
                [
                    SmallCate[id=1100, name='JavaScript'], 
                    SmallCate[id=1101, name='HTML/CSS'], 
                    SmallCate[id=1102, name='React'], 
                    SmallCate[id=1103, name='Vue.js'], 
                    SmallCate[id=1104, name='jQuery'], 
                    SmallCate[id=1105, name='TypeScript'], 
                    SmallCate[id=1106, name='ES6'], 
                    SmallCate[id=1107, name='Node.js'], 
                    SmallCate[id=1108, name='Next.js'], 
                    SmallCate[id=1109, name='웹앱'], 
                    SmallCate[id=1110, name='Redux']
                ]
            ], 
            MiddleCate
            [
                id=12, name='백앤드', 
                smallCates=
                [
                    SmallCate[id=1200, name='Spring'], 
                    SmallCate[id=1201, name='Java'], 
                    SmallCate[id=1202, name='Spring Boot'], 
                    SmallCate[id=1203, name='Node.js'], 
                    SmallCate[id=1204, name='AWS'], 
                    SmallCate[id=1205, name='JavaScript'], 
                    SmallCate[id=1206, name='JPA'], 
                    SmallCate[id=1207, name='Docker'], 
                    SmallCate[id=1208, name='Express'], 
                    SmallCate[id=1209, name='MongoDB'], 
                    SmallCate[id=1210, name='Python']
                ]
            ]
        ]
    ]
]

