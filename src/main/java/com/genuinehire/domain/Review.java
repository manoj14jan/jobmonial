package com.genuinehire.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long reviewid;

    @NotNull(message = "{company_code.error}")
    @Column(name = "company_code")
    private Integer company_code;

    @NotNull(message = "{interview_rating.error}")
    @Min(value = 1,message = "{interview_rating.min.error}")
    @Max(value = 5,message = "{interview_rating.max.error}")
    @Column(name = "interview_rating")
    private Integer interview_rating;

    @NotNull(message = "{salary_Rating.error}")
    @Min(value = 1,message = "{salary_Rating.min.error}")
    @Max(value = 5,message = "{salary_Rating.max.error}")
    @Column(name = "salary_Rating")
    private Integer salary_Rating;

    @NotNull(message = "{work_life_balance.error}")
    @Min(value = 1,message = "{work_life_balance.min.error}")
    @Max(value = 5,message = "{work_life_balance.max.error}")
    @Column(name = "work_life_balance")
    private Integer work_life_Balance;

    @NotEmpty
    @Column(name = "Comments")
    private String comments;

    public Integer getCompany_code() {
        return company_code;
    }

    public void setCompany_code(Integer company_code) {
        this.company_code = company_code;
    }

    public Integer getInterview_rating() {
        return interview_rating;
    }

    public void setInterview_rating(Integer interview_rating) {
        this.interview_rating = interview_rating;
    }

    public Integer getSalary_Rating() {
        return salary_Rating;
    }

    public void setSalary_Rating(Integer salary_Rating) {
        this.salary_Rating = salary_Rating;
    }

    public Integer getWork_life_Balance() {
        return work_life_Balance;
    }

    public void setWork_life_Balance(Integer work_life_Balance) {
        this.work_life_Balance = work_life_Balance;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    public Long getReviewid() {
        return reviewid;
    }

    public void setReviewid(Long reviewid) {
        this.reviewid = reviewid;
    }
}
