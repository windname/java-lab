package com.vg.java.core.lambda;

import java.util.Optional;

public class NullChecks {
	public static void main(String[] str) {
		new NullChecks();
	}

	public NullChecks() {
		Optional<String> str = getString();
		str.ifPresent(System.out::println);

		Optional<String> nullString = getNull();
		nullString.ifPresent(System.out::println); // do nothing

		String def = getEmpty().orElse("Default");
		System.out.println(def);

		// filter result
		getString().filter(s -> isLongString(s)).ifPresent(System.out::println); // nothing due to short string
		getLongString().filter(s -> isLongString(s)).ifPresent(System.out::println);

		Optional<Article> article = getNullArticle();
		article.map(Article::getName).ifPresent(System.out::println); // nothing article is null
		getArticle(null).map(Article::getName).ifPresent(System.out::println); // nothing name is null
		getArticle("my Article").map(Article::getName).ifPresent(System.out::println); // returns article name
		
		String name = getArticle("new article").map(Article::getName).orElse("Default Article");
		System.out.println("article name =" + name);
		name = getNullArticle().map(Article::getName).orElse("Default Article");
		System.out.println("article name =" + name);
		
		if (!getNullArticle().isPresent()) {
			System.out.println("Nothing!");
		}
		

	}

	public void print(Article a) {
		System.out.println(a.getName());
	}

	public Optional<String> getNull() {
		return Optional.ofNullable(null);
	}

	public Optional<String> getEmpty() {
		return Optional.empty();
	}

	public Optional<String> getString() {
		return Optional.of("Hello");
	}

	public Optional<String> getLongString() {
		return Optional.of("HelloWorld");
	}

	public boolean isLongString(String s) {
		if (s.length() > 5) {
			return true;
		}
		return false;
	}

	public Optional<Article> getNullArticle() {
		return Optional.ofNullable(null);
	}

	public Optional<Article> getArticle(String name) {
		return Optional.ofNullable(new Article(name));
	}

	class Article {
		private String name;

		public Article(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	class Magazine {
		private Article a;

		public Article getA() {
			return a;
		}

		public void setA(Article a) {
			this.a = a;
		}
	}
}
