package springkomis.komis.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import springkomis.komis.klasy.Samochod;

public interface SamochodRepo extends JpaRepository<Samochod, Integer> {
    
    Samochod findByIdIs(Integer id);

    List<Samochod> findByCenaBetween(Integer x, Integer y);

    List<Samochod> findAllBySprzedanyIs(int a);
   
    // List<Samochod> findAllByDataPrzegladGreaterThanEqualAndDataPrzegladLessThanEqual(Date a, Date b);

    List<Samochod> findAllByDataPrzegladBetweenOrDataUbezpieczeniaBetween(Date a, Date b, Date c, Date d);
}

    //LISTA OPERATOROW DO TWORZENIA ZAPYTAN
/*

IsAfter, After, IsGreaterThan, GreaterThan;
IsGreaterThanEqual, GreaterThanEqual;
IsBefore, Before, IsLessThan, LessThan;
IsLessThanEqual, LessThanEqual;
IsBetween, Between;
IsNull, Null;
IsNotNull, NotNull;
IsIn, In;
IsNotIn, NotIn;
IsStartingWith, StartingWith, StartsWith;
IsEndingWith, EndingWith, EndsWith;
IsContaining, Containing, Contains;
IsLike, Like;
IsNotLike, NotLike;
IsTrue, True;
IsFalse, False;
Is, Equals;
IsNot, Not;
And, Or
OrderBy
*/