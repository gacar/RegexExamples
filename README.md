# RegexExamples
java regex example usages

masking letters other than the first letter
  
  (?<=[a-zA-Z])[a-z+]
```
//name and surname: Luke Skywalker
    String result = nameSurname.replaceAll("(?<=[a-zA-Z])[a-z+]","*");
    System.out.println("Masked Name: " + result);
//Masked Name: L*** S********
```
alternative way 

(?<=\w)\w

```
result = nameSurname.replaceAll("(?<=\\w)\\w","*");
System.out.println("Masked Name alternative way: " + result);
//Masked Name alternative way: L*** S********
```

masking without giving length information

(?<=\w)\w+
```
result = nameSurname.replaceAll("(?<=\\w)\\w+","*****");
System.out.println("Masked Name: " + result);
//Masked Name: L***** S*****
```

masking identity number

(?<=\\w)\\w
```
result  = identitiyNo.replaceAll("(?<=\\w)\\w","*");
        System.out.println("Masked Identity: " + result);
        //Masked Identity: 1**********
```

mask identity but not first and last

(?<=\\w)(\\w{9})
```
result  = identitiyNo.replaceAll("(?<=\\w)(\\w{9})","*********");
System.out.println("Masked Identity: " + result);
//Masked Identity: 1*********1
```

mask email foo@bar.com ⇒ f**@b**.com
```
String email = "foo@bar.com";
System.out.println("foo@bar.com ⇒ f**@b**.com");
result = email.replaceAll("(?<=.)[^@](?=[^@]*?@)|(?:(?<=@.)|(?!^)\\G(?=[^@]*$)).(?=.*\\.)", "*");
System.out.println("Masked email: " + result);
//Masked email: f**@b**.com
```

mask email 
```     
System.out.println("foo@bar.com ⇒ f*o@b*r.com");
result = email.replaceAll("(?<=.)[^@](?=[^@]*?[^@]@)|(?:(?<=@.)|(?!^)\\G(?=[^@]*$)).(?=.*[^@]\\.)", "*");
System.out.println("Masked email: " + result);
//Masked email: f*o@b*r.com
```

validate email
```  
String simpleEmailRegex = "^(.+)@(.+)$";
String emailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
String emailTestString = "test@test.com";

if(emailTestString.matches(emailRegex))
{
    System.out.println(emailTestString + " matched with regex");
}
```  