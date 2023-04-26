package com.ssafy.mmart.domain.reviewImage

import com.ssafy.mmart.domain.Base
import com.ssafy.mmart.domain.item.Item
import com.ssafy.mmart.domain.review.Review
import com.ssafy.mmart.domain.user.User
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.*

@Entity
data class ReviewImage (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewImageIdx")
    var reviewImageIdx: Int? = null,

    @Column(name = "image")
    var image : String?="",

    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name="reviewIdx")
    var review: Review,

    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name="itemIdx")
    var item : Item,

    @ManyToOne
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JoinColumn(name="userIdx")
    var user : User,

    ): Base()