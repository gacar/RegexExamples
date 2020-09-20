package com.tutorial.regex;

public class Main {

    /* In this example we are going to display some usages of regex operations
           test your regex from https://regex101.com/
           https://stackoverflow.com/questions/43003138/regular-expression-for-email-masking
    */
    public static void main(String[] args) {
        System.out.println("Starting Tutorial ...");
        System.out.println("---\n");

        System.out.println("masking letters other than the first letter");
        String nameSurname = "Luke Skywalker";
        System.out.println("name and surname: " +nameSurname);
        String result = nameSurname.replaceAll("(?<=[a-zA-Z])[a-z+]","*");
        System.out.println("Masked Name: " + result);
        result = nameSurname.replaceAll("(?<=\\w)\\w","*");
        System.out.println("Masked Name alternative way: " + result);
        System.out.println("---\n");
        System.out.println("masking without giving length information");
        result = nameSurname.replaceAll("(?<=\\w)\\w+","*****");
        System.out.println("Masked Name: " + result);
        System.out.println("---\n");
        System.out.println("masking identity number also same");
        String identitiyNo ="12345678901";
        result  = identitiyNo.replaceAll("(?<=\\w)\\w","*");
        System.out.println("Masked Identity: " + result);

        System.out.println("mask identity but not first and last");
        result  = identitiyNo.replaceAll("(?<=\\w)(\\w{9})","*********");
        System.out.println("Masked Identity: " + result);
        System.out.println("---\n");
        System.out.println("masking e-mail address");

        String email = "foo@bar.com";
        System.out.println("foo@bar.com ⇒ f**@b**.com");
        result = email.replaceAll("(?<=.)[^@](?=[^@]*?@)|(?:(?<=@.)|(?!^)\\G(?=[^@]*$)).(?=.*\\.)", "*");
        System.out.println("Masked email: " + result);
        System.out.println("---");
        System.out.println("foo@bar.com ⇒ f*o@b*r.com");
        result = email.replaceAll("(?<=.)[^@](?=[^@]*?[^@]@)|(?:(?<=@.)|(?!^)\\G(?=[^@]*$)).(?=.*[^@]\\.)", "*");
        System.out.println("Masked email: " + result);
        System.out.println("---\n");


        System.out.println("Validate E-mail");
        //https://howtodoinjava.com/java/regex/java-regex-validate-email-address/
        String simpleEmailRegex = "^(.+)@(.+)$";
        String emailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        String emailTestString = "test@test.com";
        if(emailTestString.matches(emailRegex))
        {
            System.out.println(emailTestString + " matched with regex");
        }
        String emailTestString2 = "abcdefgh";
        if(!emailTestString2.matches(emailRegex))
        {
            System.out.println(emailTestString2 + " does not matched with regex");
        }





    }
}
