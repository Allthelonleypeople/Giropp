package users;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> lName;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> fName;
	public static volatile SingularAttribute<User, String> email;

}

