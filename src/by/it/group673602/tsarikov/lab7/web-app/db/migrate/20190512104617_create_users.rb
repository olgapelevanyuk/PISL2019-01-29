class CreateUsers < ActiveRecord::Migration[5.2]
  def change
    create_table :users do |t|
      t.string :name
      t.string :surname
      t.string :fathername
      t.date :birthday
      t.string :sex
      t.string :passport_series
      t.integer :passport_id
      t.string :identification_number
      t.string :city
      t.string :address
      t.string :home_telephone
      t.string :mobile_telephone
      t.string :email
      t.string :work_position
      t.string :nationality

      t.timestamps
    end
  end
end
