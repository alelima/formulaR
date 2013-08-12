
class Java::JavaMath::BigDecimal
  
  def + (operand)
    self.add(convertToBigDecimal operand);
  end
  
  def - (operand)
    self.subtract(convertToBigDecimal operand);
  end
  
  def * (operand)
    self.multiply(convertToBigDecimal operand);      
  end
      
  def / (operand)
    self.divide(convertToBigDecimal(operand), Java::JavaMath::RoundingMode::HALF_EVEN);      
  end
    
  def convertToBigDecimal number
    if not number.is_a?(Java::JavaMath::BigDecimal)
      number = Java::JavaMath::BigDecimal.new(number.to_s)
    end 
    number
  end
  
end
