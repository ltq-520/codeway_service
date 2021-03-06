package com.codeway.model.dto;

import com.codeway.pojo.BasePojo;
import com.codeway.pojo.article.Category;
import com.codeway.pojo.article.Tags;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ArticleDto extends BasePojo implements Serializable {

	private Category category;

	@ApiModelProperty(value = "推荐阅读",example = "1")
	@Transient
	private String related;

	@ApiModelProperty("用户名")
	@Transient
	private String userName;

	@JoinTable(
			name = "ar_article_tags",
			joinColumns = @JoinColumn(name = "article_id",referencedColumnName="id",foreignKey=@ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT) ),
			inverseJoinColumns = @JoinColumn(name = "tags_id",referencedColumnName="id",foreignKey=@ForeignKey(name="none",value = ConstraintMode.NO_CONSTRAINT)))
	@ManyToMany
	private Set<Tags> tags = new HashSet<>();

	@ApiModelProperty("ID")
	@Id
	@Column(name = "id", unique = true, nullable = false, updatable = false, length = 20)
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "com.codeway.config.IdGeneratorConfig")
	private String id;

	@ApiModelProperty("用户ID")
	@Column(length = 20)
	private String userId;

	@ApiModelProperty("标题")
	@NotNull(message = "标题不能为空")
	@Column(length = 50)
	private String title;

	@ApiModelProperty("文章封面")
	@Column(length = 200)
	private String image;

	@ApiModelProperty(value = "是否公开",example = "1")
	@Column(length = 1)
	private Integer isPublic;

	@ApiModelProperty(value = "是否置顶",example = "1")
	@Column(length = 1)
	private Integer isTop;

	@ApiModelProperty(value = "浏览量",example = "1")
	@Column(length = 5)
	private Integer visits;

	@ApiModelProperty(value = "点赞数",example = "1")
	@Column(length = 5)
	private Integer upvote;

	@ApiModelProperty("评论数")
	@Column(length = 5)
	private Integer comment;

	@ApiModelProperty(value = "审核状态",example = "1")
	@Column(length = 1)
	private Integer reviewState;

	@ApiModelProperty("URL")
	@Column(length = 200)
	private String url;

	@ApiModelProperty("类型")
	@Column(length = 1)
	private Integer type;

	@ApiModelProperty("热度")
	@Column(precision = 2, scale = 1,length = 5)
	private float importance;

	@ApiModelProperty("文章描述（概述）")
	@NotNull(message = "概述不能为空")
	@Column(length = 500)
	private String description;

	@ApiModelProperty("关键字")
	@Column(length = 200)
	private String keywords;

	@ApiModelProperty("来源（1：原创，2：转载，3：混撰）")
	@NotNull(message = "来源不能为空")
	@Column(length = 1)
	private Integer origin;

	@ApiModelProperty("文章正文")
	@NotNull(message = "内容不能为空")
	@Lob
	@Column(columnDefinition = "text")
	private String content;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ArticleDto)) return false;
		ArticleDto article = (ArticleDto) o;
		return Float.compare(article.importance, importance) == 0 &&
				Objects.equals(related, article.related) &&
				Objects.equals(userName, article.userName) &&
				id.equals(article.id) &&
				Objects.equals(userId, article.userId) &&
				Objects.equals(title, article.title) &&
				Objects.equals(image, article.image) &&
				Objects.equals(isPublic, article.isPublic) &&
				Objects.equals(isTop, article.isTop) &&
				Objects.equals(visits, article.visits) &&
				Objects.equals(upvote, article.upvote) &&
				Objects.equals(comment, article.comment) &&
				Objects.equals(reviewState, article.reviewState) &&
				Objects.equals(url, article.url) &&
				Objects.equals(type, article.type) &&
				Objects.equals(description, article.description) &&
				Objects.equals(keywords, article.keywords) &&
				Objects.equals(origin, article.origin) &&
				Objects.equals(content, article.content);
	}

	@Override
	public int hashCode() {
		return Objects.hash(related, userName, id, userId, title, image, isPublic, isTop, visits, upvote, comment, reviewState, url, type, importance, description, keywords, origin, content);
	}

	@Override
	public String toString() {
		return "Article{" +
				"related='" + related + '\'' +
				", userName='" + userName + '\'' +
				", id='" + id + '\'' +
				", userId='" + userId + '\'' +
				", title='" + title + '\'' +
				", image='" + image + '\'' +
				", isPublic=" + isPublic +
				", isTop=" + isTop +
				", visits=" + visits +
				", upvote=" + upvote +
				", comment=" + comment +
				", reviewState=" + reviewState +
				", url='" + url + '\'' +
				", type=" + type +
				", importance=" + importance +
				", description='" + description + '\'' +
				", keywords='" + keywords + '\'' +
				", origin=" + origin +
				", content='" + content + '\'' +
				'}';
	}
}