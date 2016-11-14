package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.*;



/**
 * Company entity managed by Ebean
 */
@Entity 
public class TarjetaVideo extends com.avaje.ebean.Model {

    private static final long serialVersionUID = 1L;

	@Id
    public Long id;
    
    @Constraints.Required
    public String name;
    
    @Constraints.Required
    public int peso;
    
    @Constraints.Required
    public int capacidad;
    
    
    /**
     * Generic query helper for entity Company with id Long
     * @Constraints.Required
    public int capacidad;
     */
    public static Find<Long,TarjetaVideo> find = new Find<Long,TarjetaVideo>(){};

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(TarjetaVideo c: TarjetaVideo.find.orderBy("name").findList()) {
            options.put(c.id.toString(), c.name);
        }
        return options;
    }

}
