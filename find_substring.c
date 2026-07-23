#include <stdio.h>

int find_substring(const char *haystack,const char *needle){
    if (*needle == '\0') return 0;
const char *temp = haystack;
while(*temp!='\0'){
const char *start_needle = needle;
if(*temp == *start_needle){
    const char *st = temp;
    while(*start_needle == *st && *start_needle!='\0'){
        start_needle++;
        st++;
    }
    if(*start_needle=='\0')return temp-haystack;
}
 temp++;
}
return -1;
}

int main(){
    char haystack[] = "Embedded Systems";
    char needle[] = "bed";
    printf("%d",find_substring(haystack,needle));


}