package Forum;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Questions.class)
public abstract class Questions_ {

	public static volatile SingularAttribute<Questions, Integer> QuestionID;
	public static volatile SingularAttribute<Questions, String> navn;
	public static volatile SingularAttribute<Questions, String> kategori;
	public static volatile SingularAttribute<Questions, String> QuestionText;

}

