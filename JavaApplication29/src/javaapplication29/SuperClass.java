/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication29;

/**
 *
 * @author mmahf
 */
class SuperClass{
int a, b, c;
SuperClass(int p, int q, int r){
a=p;b=q;c=r;
}
void Show()
{
System.out.println("a = " + a);
System.out.println("b = " + b);
System.out.println("c = " + c);
}
void Show(String s){
System.out.println(s);
}}
class SubClass extends SuperClass{
int d;
SubClass(int l, int m, int n, int o)
{ super(l,m,n);d=o;
}
