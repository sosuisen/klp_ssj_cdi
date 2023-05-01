package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Named;

@Alternative
@Named("history")
@SessionScoped
public class HistoryWithDate extends AbstractHistory implements Serializable {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
	@Override
	public boolean add(String str) {
		return super.add(sdf.format(new Date()) + " " + str);
	}
}
