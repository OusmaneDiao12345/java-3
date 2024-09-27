package repositories;

import entities.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private List<Article> articles = new ArrayList<>();

    public void addArticle(Article article) {
        articles.add(article);
    }

    public List<Article> getArticles() {
        return articles;
    }

    public List<Article> getAvailableArticles() {
        List<Article> result = new ArrayList<>();
        for (Article article : articles) {
            if (article.getQuantityInStock() > 0) {
                result.add(article);
            }
        }
        return result;
    }

    public void updateStock(Article article, int newQuantity) {
        article.setQuantityInStock(newQuantity);
    }
}
