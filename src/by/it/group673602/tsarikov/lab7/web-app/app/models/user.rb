class User < ApplicationRecord
  validates :name, presence: true, length: {minimum: 3}
  validates :surname, presence: true, length: {minimum: 5}
  validates :birthday, presence: true
  validates :sex, presence: true
  validates :passport_series, presence: true, length: {minimum: 2}
  validates :passport_id, presence: true, length: {minimum: 6, maximum: 8}
  validates :identification_number, presence: false, length: {minimum: 10}
  validates :city, presence: true
  validates :nationality, presence: true
  validates :address, presence: true
  validates :mobile_telephone, presence: true, length: {minimum: 13}
end
