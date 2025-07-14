#ifndef fraction_h
#define fraction_h
#include <iostream>

class Fraction {
    private:
        int numerator;
        int denominator;
    public:
        Fraction();
        Fraction(int num, int denom);

        int gcd(int a, int b) const;
        void simplify();
        friend bool isEqual(const Fraction& f1, const Fraction& f2);
        friend std::ostream& operator<<(std::ostream& os, const Fraction& f);
};
#endif