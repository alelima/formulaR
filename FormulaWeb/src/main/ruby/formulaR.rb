
class Java::JavaMath::BigDecimal
  
  def + (operand)
    self.add(convert_to_big_decimal operand);
  end
  
  def - (operand)
    self.subtract(convert_to_big_decimal operand);
  end
  
  def * (operand)
    self.multiply(convert_to_big_decimal operand);      
  end
      
  def / (operand)
    self.divide(convert_to_big_decimal(operand), 4, Java::JavaMath::RoundingMode::HALF_EVEN);      
  end
    
  def convert_to_big_decimal number
    if not number.is_a?(Java::JavaMath::BigDecimal)
      number = Java::JavaMath::BigDecimal.new(number.to_s)
    end 
    number
  end
  
end
