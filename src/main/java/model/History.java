package model;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@SessionScoped
@Named
public class History extends ArrayList<String> implements Serializable {
	// History は ArrayList<String> を継承しているため、
	// ArrayListクラスと同じメソッドを持つ CDI Bean です。
}
