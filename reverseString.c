#include <stdio.h>

void reverse_string(char *str){
char *start = str;
char *end = str;
while(*end!='\0'){
    end++;
}
end--;
while(start<end){
    char temp = *start;
    *start = *end;
    *end = temp;
    start++;
    end--;
}
}

int main(){
    char str[] = "Data Structures";
    reverse_string(str);
    printf("%s",str);
}