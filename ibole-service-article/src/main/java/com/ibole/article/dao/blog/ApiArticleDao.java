package com.ibole.article.dao.blog;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ibole.pojo.QueryVO;
import com.ibole.pojo.article.Article;

/**
 * 文章数据处理层
 **/


public interface ApiArticleDao extends BaseMapper<Article> {

	IPage<Article> findArticlePage(Page page, QueryVO queryVO);

	/**
	 * 审核文章
	 *
	 * @param id
	 */
	void examine(String id);

	/**
	 * 点赞
	 *
	 * @param id
	 * @return
	 */
	int updateThumbUp(String id);
}
