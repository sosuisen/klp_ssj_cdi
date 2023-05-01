package model;

import java.io.Serializable;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Named;

@SessionScoped
@Alternative
@Named("history")
public class HistoryTest extends AbstractHistory implements Serializable {
	@PostConstruct
	public void init() {
		// list へ直接テスト用データを追加
		// テキストファイルからデータをロードするという方法もある
		this.add("こんにちは。");
		this.add("HistoryTestが注入されました。");
		this.add("これはテスト用データです！");
	}
}
