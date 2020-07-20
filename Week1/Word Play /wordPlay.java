
/**
 * Write a description of wordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wordPlay {
boolean isVowel(char ch){
  
  String vowel="aeiou";
  char ch1=Character.toLowerCase(ch);
  if(vowel.indexOf(ch)!=-1 || vowel.indexOf(ch1)!=-1)
     return true;
 return false;

}
String  replaceVowels (String phrase,char ch){
    StringBuilder str= new StringBuilder(phrase);
for(int i=0;i<phrase.length();i++){
  if(isVowel(phrase.charAt(i))){
      str.setCharAt(i,ch);
    }
}
return str.toString();
}
String  emphasize(String phrase,char ch){
    StringBuilder str= new StringBuilder(phrase);
    char a='*';
    for(int i=0;i<phrase.length();i++){
   if(i%2==0)
      a='*';
   else
      a='+';
    if(phrase.charAt(i)==ch){
      str.setCharAt(i,a);
    }
}
return str.toString();
}
}
