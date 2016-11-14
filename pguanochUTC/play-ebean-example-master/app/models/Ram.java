package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

/**
 * Computer entity managed by Ebean
 */
@Entity
public class Ram extends Model {


	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Constraints.Required
	public String descripcion;

	@Constraints.Required
	public Integer capacidad;
	
	@Constraints.Required
	public Integer velocidad;

	@ManyToOne
	public Computer computer;

	/**
	 * Generic query helper for entity Computer with id Long
	 */
	public static Find<Long, Ram> find = new Find<Long, Ram>() {
	};

	public static PagedList<Ram> page(int page, int pageSize,
			String sortBy, String order, String filter) {
		System.out.println("filter:" + filter);
		return find.where().ilike("capacidad", "%" + filter + "%")
				.orderBy(sortBy + " " + order).fetch("computer")
				.findPagedList(page, pageSize);

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
